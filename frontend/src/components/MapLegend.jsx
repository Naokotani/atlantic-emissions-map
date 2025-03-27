import React from "react";
import "../styles/legend.css";

function MapLegend() {
  return (
    <div className="map-legend">
      <h4>Greenhouse Gas Types</h4>
      <div className="legend-list">
        <div className="legend-item">
          <div className="color-box color-co2"></div>
          <span className="legend-label">CO₂ (Carbon Dioxide)</span>
        </div>
        <div className="legend-item">
          <div className="color-box color-ch4"></div>
          <span className="legend-label">CH₄ (Methane)</span>
        </div>
        <div className="legend-item">
          <div className="color-box color-n2o"></div>
          <span className="legend-label">N₂O (Nitrous Oxide)</span>
        </div>
        <div className="legend-item">
          <div className="color-box color-sf6"></div>
          <span className="legend-label">SF₆ (Sulfur Hexafluoride)</span>
        </div>
        <div className="legend-item">
          <div className="color-box color-hfc"></div>
          <span className="legend-label">HFC (Hydrofluorocarbons)</span>
        </div>
        <div className="legend-item">
          <div className="color-box color-pfc"></div>
          <span className="legend-label">PFC (Perfluorocarbons)</span>
        </div>
      </div>
    </div>
  );
}

export default MapLegend;
