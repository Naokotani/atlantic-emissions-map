import MapLegend from "./MapLegend";

function MapForm({ filters, setFilters, availableYears, loading }) {
  const handleYearChange = (e) => {
    setFilters((prevFilters) => ({
      ...prevFilters,
      year: e.target.value,
    }));
  };

  const handleProvinceChange = (e) => {
    setFilters((prevFilters) => ({
      ...prevFilters,
      province: e.target.value,
    }));
  };

  const handleEmissionChange = (e) => {
    setFilters((prevFilters) => ({
      ...prevFilters,
      emissionType: e.target.value,
    }));
  };

  const handleSourceChange = (e) => {
    setFilters((prevFilters) => ({
      ...prevFilters,
      emissionSource: e.target.value,
    }));
  };

  const generateYearOptions = () => {
    return availableYears.map((year) => (
      <option key={year} value={year.toString()}>
        {year}
      </option>
    ));
  };

  return (
    <div className="filter-form">
      {/* Year filter */}
      <div className="filter-group">
        <label htmlFor="year">Year:</label>
        <select
          id="year"
          value={filters.year}
          onChange={handleYearChange}
          disabled={loading}
        >
          <option value="all">All</option>
          {loading ? (
            <option value="" disabled>
              Loading years...
            </option>
          ) : (
            generateYearOptions()
          )}
        </select>
      </div>

      {/* Province filter */}
      <div className="filter-group">
        <label htmlFor="province">Province:</label>
        <select
          id="province"
          value={filters.province}
          onChange={handleProvinceChange}
        >
          <option value="all">All</option>
          <option value="novaScotia">Nova Scotia</option>
          <option value="newBrunswick">New Brunswick</option>
          <option value="pei">Prince Edward Island</option>
        </select>
      </div>

      {/* Emission type filter */}
      <div className="filter-group">
        <label htmlFor="emissionType">GHG:</label>
        <select
          id="emissionType"
          value={filters.emissionType}
          onChange={handleEmissionChange}
        >
          <option value="all">All</option>
          <option value="carbonDioxide">C02</option>
          <option value="methane">CH4</option>
          <option value="nitrousOxide">N20</option>
          <option value="sulphurHexaflouride">SF6</option>
          <option value="hydroflourocarbons">HFC</option>
          <option value="perfluorocarbons">PFC</option>
        </select>
      </div>

      {/* Source Filter */}
      {/* Covers baseline emission sources, should condense later. Also check if any missing */}
      <div className="filter-group">
        <label htmlFor="emissionSource">Source:</label>
        <select
          id="emissionSource"
          value={filters.emissionSource}
          onChange={handleSourceChange}
        >
          <option value="all">All</option>
          <option value="Cement Manufacturing">Cement Manufacturing</option>
          <option value="Fossil-Fuel Electric Power Generation">
            Fossil Fuel Power Generation
          </option>
          <option value="Chemical Pulp Mills">Chemical Pulp Mills</option>
          <option value="Tire Manufacturing">Tire Manufacturing</option>
          <option value="Oil and gas extraction (except oil sands)">
            Oil and Gas Extraction
          </option>
          <option value="Waste Treatment and Disposal">
            Waste Treatment and Disposal
          </option>
          <option value="Other Electric Power Generation">
            Other Electric Power Generation
          </option>
          <option value="Defence Services">Defence Services</option>
          <option value="Universities">Universities</option>
          <option value="All Other Converted Paper Product Manufacturing">
            All Other Converted Paper Product Manufacturing
          </option>
          <option value="Particle Board and Fibreboard Mills">
            Particle Board and Fibreboard Mills
          </option>
          <option value="Gold and Silver Ore Mining">
            Gold and Silver Ore Mining
          </option>
          <option value="Bituminous Coal Mining">Bituminous Coal Mining</option>
          <option value="Frozen Food Manufacturing">
            Frozen Food Manufacturing
          </option>
          <option value="Lime Manufacturing">Lime Manufacturing</option>
          <option value="Petroleum Refineries">Petroleum Refineries</option>
          <option value="Paper (except Newsprint) Mills">
            Paper (except Newsprint) Mills
          </option>
          <option value="Paperboard Mills">Paperboard Mills</option>
          <option value="Natural Gas Distribution">
            Natural Gas Distribution
          </option>
          <option value="All Other Food Manufacturing">
            All Other Food Manufacturing
          </option>
          <option value="Gypsum Product Manufacturing">
            Gypsum Product Manufacturing
          </option>
          <option value="Lead-Zinc Ore Mining">Lead-Zinc Ore Mining</option>
        </select>
      </div>
      <MapLegend />
    </div>
  );
}

export default MapForm;
