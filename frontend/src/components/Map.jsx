import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import { divIcon } from "leaflet";
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from "chart.js";
import { Pie } from "react-chartjs-2";

function Map({ data }) {
  return (
    <MapContainer
      center={[46, -64.0]} //Decent fitment for the time being (centered on maritimes)
      zoom={6}
      style={{ height: "500px", width: "500px" }} // Base 500x500 map for now until future formatting.
    >
      <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png" />
      {data.map((item, index) => (
        <Marker
          // Nasty unique key because multiple ids the same exist in the response -- lazy fix but it works
          key={`${item.id}-${item.latitude}-${item.longitude}-${index}`}
          position={[item.latitude, item.longitude]}
        >
          <Popup>
            {/* Clean this up later */}
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
      ))}
    </MapContainer>
  );
}

export default Map;
