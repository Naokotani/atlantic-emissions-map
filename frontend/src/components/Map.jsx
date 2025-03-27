import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import { divIcon } from "leaflet";
import {
  Chart as ChartJS,
  ArcElement,
  Tooltip,
  Legend,
  PieController,
} from "chart.js";
import { useEffect, useState, useMemo } from "react";
import MarkerClusterGroup from "react-leaflet-cluster";
import "../styles/map.css";

ChartJS.register(ArcElement, Tooltip, Legend, PieController);

// Chart colors
const chartColors = [
  "#FF6384", // CO2
  "#36A2EB", // CH4
  "#FFCE56", // N2O
  "#4BC0C0", // SF6
  "#9966FF", // HFCs
  "#FF9F40", // PFCs
];

const createChartIcon = (emissions) => {
  const canvas = document.createElement("canvas");
  canvas.width = 60;
  canvas.height = 60;

  const chartData = {
    datasets: [
      {
        data: emissions.map((val) => (val > 0 ? Math.sqrt(val) : 0)),
        backgroundColor: chartColors,
        borderWidth: 0,
      },
    ],
  };

  const chart = new ChartJS(canvas, {
    type: "pie",
    data: chartData,
    options: {
      plugins: { legend: { display: false } },
      responsive: false,
      animation: false,
    },
  });

  const dataUrl = canvas.toDataURL();
  chart.destroy();

  return divIcon({
    className: "custom-div-icon",
    html: `<div style="background-image:url('${dataUrl}');
           width:60px;height:60px;background-size:contain;"></div>`,
    iconSize: [60, 60],
    iconAnchor: [30, 30],
  });
};

const createClusterIcon = (cluster) => {
  const markers = cluster.getAllChildMarkers();

  const combinedEmissions = [0, 0, 0, 0, 0, 0];

  markers.forEach((marker) => {
    const emissionsData = marker.options.emissionsData;
    if (emissionsData) {
      combinedEmissions[0] += emissionsData[0] || 0;
      combinedEmissions[1] += emissionsData[1] || 0;
      combinedEmissions[2] += emissionsData[2] || 0;
      combinedEmissions[3] += emissionsData[3] || 0;
      combinedEmissions[4] += emissionsData[4] || 0;
      combinedEmissions[5] += emissionsData[5] || 0;
    }
  });

  const chartIcon = createChartIcon(combinedEmissions);

  const count = cluster.getChildCount();
  const size = Math.min(90, 60 + Math.log(count) * 15);

  return divIcon({
    html: `<div style="
      background-image:url('${
        chartIcon.options.html.match(/url\('([^']+)'\)/)[1]
      }');
      width:${size}px;height:${size}px;
      background-size:contain;
      display:flex;
      justify-content:center;
      align-items:center;
      font-weight:bold;
      color:white;
      text-shadow: 0px 0px 2px black;
    ">${count}</div>`,
    className: "custom-cluster-icon",
    iconSize: [size, size],
    iconAnchor: [size / 2, size / 2],
  });
};

function Map({ data }) {
  const [markerIcons, setMarkerIcons] = useState({});

  // Process data only when it changes
  const validData = useMemo(
    () => data?.filter((item) => item.latitude && item.longitude) || [],
    [data]
  );

  useEffect(() => {
    if (validData.length === 0) {
      setMarkerIcons({});
      return;
    }

    const icons = {};

    validData.forEach((item, index) => {
      const key = `${item.id}-${item.latitude}-${item.longitude}-${index}`;

      // Extract emission values for pie chart data
      const emissions = [
        item.carbonDioxide,
        item.methane,
        item.nitrousOxide,
        item.sulphurHexaflouride,
        item.hydroflourocarbons,
        item.perfluorocarbons,
      ];

      // Skip items with no emissions
      if (emissions.every((e) => !e)) return;

      // Create icon using helper function
      icons[key] = createChartIcon(emissions);
    });

    setMarkerIcons(icons);

    return () => setMarkerIcons({});
  }, [validData]);

  return (
    <div>
      <MapContainer
        center={[46, -64.0]}
        zoom={6}
        // style={{ height: "500px", width: "500px" }}
      >
        <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png" />

        <MarkerClusterGroup
          chunkedLoading
          iconCreateFunction={createClusterIcon}
          spiderfyOnMaxZoom={true}
          showCoverageOnHover={false}
        >
          {validData.map((item, index) => {
            const key = `${item.id}-${item.latitude}-${item.longitude}-${index}`;

            // Only render markers with icons
            if (!markerIcons[key]) return null;

            // Extract emission values
            const emissionsData = [
              item.carbonDioxide,
              item.methane,
              item.nitrousOxide,
              item.sulphurHexaflouride,
              item.hydroflourocarbons,
              item.perfluorocarbons,
            ];

            return (
              <Marker
                key={key}
                position={[item.latitude, item.longitude]}
                icon={markerIcons[key]}
                // Store emissions data to use in cluster icons
                emissionsData={emissionsData}
              >
                <Popup>
                  <div>
                    <h3>{item.facilityName}</h3>
                    <p>CO2: {item.carbonDioxide}</p>
                    <p>CH4: {item.methane}</p>
                    <p>N2O: {item.nitrousOxide}</p>
                    <p>SF6: {item.sulphurHexaflouride}</p>
                    <p>HFCs: {item.hydroflourocarbons}</p>
                    <p>PFCs: {item.perfluorocarbons}</p>
                    <p>Total Emissions: {item.totalEmissions}</p>
                  </div>
                </Popup>
              </Marker>
            );
          })}
        </MarkerClusterGroup>
      </MapContainer>
    </div>
  );
}

export default Map;
