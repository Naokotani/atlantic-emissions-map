import { useState, useEffect } from "react";

import Map from "./Map";

import MapForm from "./MapForm";

function MapWrapper() {
  const [filters, setFilters] = useState({ year: "2022" }); //Default most current data (2023 empty)

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

        setMapData(allFacilities); // Set data to be used in map
      } catch (error) {
        console.error("Error fetching map data:", error);
      }
    };

    fetchData();
  }, [filters.year]); // Re-fetch when the year filter changes

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
