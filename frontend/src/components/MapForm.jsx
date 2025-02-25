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

  return (
    <div>
      <label htmlFor="year">Select Year:</label>
      <p>Current filter: {filters.category}</p>
      <select id="year" value={filters.year} onChange={handleYearChange}>
        <option value="2023">2023</option>
        <option value="2022">2022</option>
        <option value="2021">2021</option>
        <option value="2020">2020</option>
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
    </div>
  );
}

export default MapForm;
