function MapForm({ filters, setFilters }) {
  const handleYearChange = (e) => {
    setFilters({ ...filters, year: e.target.value });
  };

  return (
    <form>
      <label htmlFor="year">Select Year:</label>
      <p>Current filter: {filters.category}</p>
      <select id="year" value={filters.year} onChange={handleYearChange}>
        <option value="2023">2023</option>
        <option value="2022">2022</option>
        <option value="2021">2021</option>
        <option value="2020">2020</option>
      </select>
    </form>
  );
}

export default MapForm;
