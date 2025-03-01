function MapForm({ filters, setFilters }) {
  const handleYearChange = (e) => {
    setFilters((prevFilters) => ({
      ...prevFilters,
      year: e.target.value,
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

  return (
    <div>
      <label htmlFor="year">Select Year:</label>
      <p>Current filter: {filters.category}</p>
      <select id="year" value={filters.year} onChange={handleYearChange}>
        <option value="2023">2023</option>
        <option value="2022">2022</option>
        <option value="2021">2021</option>
        <option value="2020">2020</option>
        <option value="2019">2019</option>
        <option value="2018">2018</option>
        <option value="2017">2017</option>
        <option value="2016">2016</option>
        <option value="2015">2015</option>
        <option value="2014">2014</option>
      </select>

      <label htmlFor="emissionType">Emission Type:</label>
      <select
        id="emissionType"
        value={filters.emissionType}
        onChange={handleEmissionChange}
      >
        <option value="all">All Emissions</option>
        <option value="carbonDioxide">C02</option>
        <option value="methane">CH4</option>
        <option value="nitrousOxide">N20</option>
        <option value="sulphurHexaflouride">SF6</option>
        <option value="hydroflourocarbons">HFC</option>
        <option value="perfluorocarbons">PFC</option>
      </select>

      {/* Covers baseline emission sources, should condense later. Also check if any missing */}
      <label htmlFor="emissionSource">Source:</label>
      <select
        id="emissionSource"
        value={filters.emissionSource}
        onChange={handleSourceChange}
      >
        <option value="all">All Sources</option>
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
  );
}

export default MapForm;
