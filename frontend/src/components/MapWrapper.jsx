import { useState, useEffect } from "react";
import Map from "./Map";
import MapForm from "./MapForm";
import "../styles/map.css";

function MapWrapper() {
  const [filters, setFilters] = useState({
    year: "all", //Default most updated year
    province: "all",
    emissionType: "all", // Default to all emissions
    emissionSource: "all",
  });

  const [mapData, setMapData] = useState([]); // Store fetched data
  const [facilityDetails, setFacilityDetails] = useState({});

  useEffect(() => {
    const fetchData = async () => {
      try {
        let apiUrl;

        if (filters.year === "all") {
          apiUrl = `/api/v1/region/maritime/all`;
        } else {
          apiUrl = `api/v1/region/maritime?years=${filters.year}`;
        }

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
          filteredData = filteredData.filter(
            (item) => item.facilityDescription === filters.emissionSource
          );
        }

        setMapData(filteredData); // Set data to be used in map
      } catch (error) {
        console.error("Error fetching map data:", error);
      }
    };

    fetchData();
  }, [
    filters.year,
    filters.province,
    filters.emissionType,
    filters.emissionSource,
  ]); // Re-fetch when the filter changes

  // Func to fetch facility details
  const fetchFacilityDetails = async (facilityId) => {
    // Don't fetch if we already have the data
    if (facilityDetails[facilityId]) return;

    try {
      const apiUrl = `/api/v1/details/${facilityId}`;

      const response = await fetch(apiUrl);
      if (!response.ok) {
        throw new Error(
          `Failed to fetch facility details: ${response.statusText}`
        );
      }

      const detailsData = await response.json();

      setFacilityDetails((prev) => ({
        ...prev,
        [facilityId]: detailsData,
      }));
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
        <MapForm filters={filters} setFilters={setFilters} />
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
