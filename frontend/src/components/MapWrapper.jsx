import { useState, useEffect } from "react";
import Map from "./Map";
import MapForm from "./MapForm";
import "../styles/map.css";

function MapWrapper() {
  const [filters, setFilters] = useState({
    year: "all",
    province: "all",
    emissionType: "all",
    emissionSource: "all",
  });

  const [mapData, setMapData] = useState([]); // Store fetched data
  const [facilityDetails, setFacilityDetails] = useState({});
  const [availableYears, setAvailableYears] = useState([]);
  const [loading, setIsLoading] = useState(true);

  // Get all available years
  useEffect(() => {
    const fetchYears = async () => {
      try {
        const response = await fetch("/api/v1/data/active");
        const data = await response.json();
        const yearsArray = data.years || [];
        const sortedYears = yearsArray.sort((a, b) => b - a);
        setAvailableYears(sortedYears);
        setIsLoading(false);
      } catch (error) {
        console.error("Error fetching available years:", error);
        setIsLoading(false);
      }
    };

    fetchYears();
  }, []);

  useEffect(() => {
    const fetchData = async () => {
      try {
        let yearsParam;
        if (filters.year === "all") {
          yearsParam = availableYears.join(",");
        } else {
          yearsParam = filters.year;
        }

        const apiUrl = `/api/v1/region/maritime?years=${yearsParam}`;
        const response = await fetch(apiUrl);
        const data = await response.json();
        console.log(data);

        let allFacilities;
        if (filters.province === "all") {
          allFacilities = Object.values(data).flat();
        } else {
          allFacilities = data[filters.province] || [];
        }

        // First filter by emission type
        let filteredData = allFacilities;

        if (filters.emissionType !== "all") {
          filteredData = filteredData.filter(
            (item) => item[filters.emissionType] > 0
          );
        }

        // Then filter by source
        if (filters.emissionSource !== "all") {
          filteredData = filteredData.filter((item) => {
            const details = facilityDetails[item.ghgrpId];

            if (!details) {
              fetchFacilityDetails(item.ghgrpId);
              return true;
            }

            return details.facilityDescription === filters.emissionSource;
          });
        }

        setMapData(filteredData); // Set data to be used in map
      } catch (error) {
        console.error("Error fetching map data:", error);
      }
    };

    if (availableYears.length > 0) {
      fetchData();
    }
  }, [filters, availableYears]); // Re-fetch when the filter changes

  // Func to fetch facility details
  const fetchFacilityDetails = async (facilityId) => {
    // Don't fetch if we already have the data
    if (facilityDetails[facilityId]) return;

    try {
      const apiUrl = `/api/v1/details?ghgrpId=${facilityId}`;
      console.log("Fetching details for:", facilityId);

      const response = await fetch(apiUrl);
      if (!response.ok) {
        throw new Error(
          `Failed to fetch facility details: ${response.statusText}`
        );
      }

      const detailsData = await response.json();
      console.log("Raw API Response:", JSON.stringify(detailsData, null, 2));

      setFacilityDetails((prev) => {
        const newState = {
          ...prev,
          [facilityId]: detailsData,
        };
        return newState;
      });
    } catch (error) {
      console.error(
        `Error fetching details for facility ${facilityId}:`,
        error
      );
      setFacilityDetails((prev) => ({
        ...prev,
        [facilityId]: { error: true, message: error.message },
      }));
    }
  };

  return (
    <section className="map-section">
      <div className="map-filter-form">
        <MapForm
          filters={filters}
          setFilters={setFilters}
          availableYears={availableYears}
          loading={loading}
        />
      </div>
      <div className="map-container">
        <Map
          data={mapData}
          facilityDetails={facilityDetails}
          onPopupOpen={fetchFacilityDetails}
        />
      </div>
    </section>
  );
}

export default MapWrapper;
