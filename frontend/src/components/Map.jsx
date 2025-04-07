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
  "#4A8C7B", // CO2 - muted teal
  "#5B6CC2", // CH4 - deep blue
  "#8C566C", // N2O - muted purple-red
  "#737C80", // SF6 - steel gray
  "#93A661", // HFCs - sage green
  "#C17B57", // PFCs - terracotta
];

// From Map.jsx
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

function Map({ data, facilityDetails, onPopupOpen }) {
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
      const key = `${item.ghgrpId}-${item.latitude}-${item.longitude}-${index}`;

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

  // Formatting for phone number
  const formatPhoneNumber = (phoneNumber) => {
    const cleaned = ("" + phoneNumber).replace(/\D/g, "");
    const match = cleaned.match(/^(\d{3})(\d{3})(\d{4})$/);

    if (match) {
      return `${match[1]}-${match[2]}-${match[3]}`;
    }

    return phoneNumber || "Phone Number N/A";
  };

  return (
    <div>
      <MapContainer
        center={[46, -64.0]}
        zoom={6}
        // style={{ height: "500px", width: "500px" }}
      >
        <TileLayer
          url="https://{s}.basemaps.cartocdn.com/dark_all/{z}/{x}/{y}{r}.png"
          attribution='&copy; <a href="https://carto.com/">Carto</a>'
        />

        <MarkerClusterGroup
          chunkedLoading
          iconCreateFunction={createClusterIcon}
          spiderfyOnMaxZoom={true}
          showCoverageOnHover={false}
        >
          {validData.map((item, index) => {
            const key = `${item.ghgrpId}-${item.latitude}-${item.longitude}-${index}`;

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

            // From Map.jsx
            return (
              <Marker
                key={key}
                position={[item.latitude, item.longitude]}
                icon={markerIcons[key]}
                // Store emissions data to use in cluster icons
                emissionsData={emissionsData}
                eventHandlers={{
                  popupopen: () => onPopupOpen(item.ghgrpId),
                }}
              >
                <Popup className="custom-popup">
                  <div className="popup-content">
                    <h3 className="facility-name">
                      {facilityDetails[item.ghgrpId]?.facilityName ||
                        item.facilityName}
                    </h3>

                    <div className="facility-location">
                      {facilityDetails[item.ghgrpId] ? (
                        <>
                          {facilityDetails[item.ghgrpId].facilityCityOrDistrict}
                          ,&nbsp;
                          {
                            facilityDetails[item.ghgrpId]
                              .facilityProvinceTerritory
                          }
                        </>
                      ) : (
                        `${item.city || ""}, ${
                          item.province || "Unknown location"
                        }`
                      )}
                    </div>

                    <div className="facility-details">
                      {facilityDetails[item.ghgrpId] ? (
                        facilityDetails[item.ghgrpId].error ? (
                          <div className="error-details">
                            Error loading facility details.
                          </div>
                        ) : (
                          <>
                            <div className="detail-row">
                              <span className="detail-value">
                                {facilityDetails[item.ghgrpId]
                                  .companyLegalName || "Parent Company N/A"}
                              </span>
                            </div>
                            <div className="detail-row">
                              <span className="detail-value">
                                {facilityDetails[item.ghgrpId]
                                  .facilityDescription || "Industry Sector N/A"}
                              </span>
                            </div>
                            <div className="detail-row">
                              <span className="detail-value">
                                {formatPhoneNumber(
                                  facilityDetails[item.ghgrpId]
                                    .publicContactTelephone
                                )}
                              </span>
                            </div>
                          </>
                        )
                      ) : (
                        <div className="loading-details">
                          Loading facility details...
                        </div>
                      )}
                    </div>

                    <div className="emissions-section">
                      <div className="total-emissions">
                        <strong>Total GHG:</strong>
                        {[
                          item.carbonDioxide,
                          item.methane,
                          item.nitrousOxide,
                          item.sulphurHexaflouride,
                          item.hydroflourocarbons,
                          item.perfluorocarbons,
                        ]
                          .filter(
                            (val) =>
                              val !== null && val !== undefined && !isNaN(val)
                          )
                          .reduce((sum, val) => sum + Number(val), 0)
                          .toFixed(0)
                          .replace(/\B(?=(\d{3})+(?!\d))/g, ",")}{" "}
                        tonnes
                      </div>
                      <div className="emissions-table">
                        {[
                          { label: "CO₂", value: item.carbonDioxide },
                          { label: "CH₄", value: item.methane },
                          { label: "N₂O", value: item.nitrousOxide },
                          { label: "SF₆", value: item.sulphurHexaflouride },
                          { label: "HFCs", value: item.hydroflourocarbons },
                          { label: "PFCs", value: item.perfluorocarbons },
                        ].map(({ label, value }) => (
                          <div className="emissions-row" key={label}>
                            <span className="emission-type">{label}:</span>
                            <span className="emission-value">
                              {value !== null && value !== undefined
                                ? `${Math.round(value).toLocaleString()} tonnes`
                                : "0 tonnes"}
                            </span>
                          </div>
                        ))}
                      </div>
                    </div>
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
