import { useState, useEffect } from "react";

import Map from "./Map";

import MapForm from "./MapForm";

function MapWrapper() {
  const [filters, setFilters] = useState({
    year: "2022", //Default most updated year
    emissionType: "all", // Default to all emissions
  });

  const [mapData, setMapData] = useState([]); // Store fetched data

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(
          `/api/v1/region/maritime?year=${filters.year}`
        );

        const data = await response.json();

        console.log(data);

        const allFacilities = Object.values(data).flat(); //Arrays inside arrays thing

        let filteredData;

        if (filters.emissionType === "all") {
          // If "all" is selected, no emission type filter is applied
          filteredData = allFacilities;
        } else {
          //Otherwise, filter by selected emission type
          filteredData = allFacilities.filter(
            (item) => item[filters.emissionType] > 0 // Check if emission type > 0
          );
        }

        setMapData(filteredData); // Set data to be used in map
      } catch (error) {
        console.error("Error fetching map data:", error);
      }
    };

    fetchData();
  }, [filters.year, filters.emissionType]); // Re-fetch when the filter changes

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
