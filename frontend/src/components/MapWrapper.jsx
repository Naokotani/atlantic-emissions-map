import { useState, useEffect } from "react";

import Map from "./Map";

import MapForm from "./MapForm";

function MapWrapper() {
  const [filters, setFilters] = useState({
    year: "all", //Default most updated year
    province: "all",
    emissionType: "all", // Default to all emissions
    emissionSource: "all",
  });

  const [mapData, setMapData] = useState([]); // Store fetched data

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

  return (
    <>
      <MapForm filters={filters} setFilters={setFilters} />
      <div>
        <Map data={mapData} />
      </div>
    </>
  );
}

export default MapWrapper;
