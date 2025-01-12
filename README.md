# Industrial Emissions Map (IEM): Atlantic Canada

V1

Date: January–April 2025\
Authors: Christopher Hughes, Nicholas Richardson, Rose Scoville


## About

The Industrial Emissions Map (IEM) displays the latest reported greenhouse gas (GHG) emissions from large industrial facilities across the Atlantic provinces. This project's goal is to make the data, and the story they tell, easily accessible to industry and non-industry Atlantic Canadians alike.

The data shown are current as of October 31, 2023, and will be updated as the latest data is released from the Government of Canada's [Greenhouse Gas Reporting Program (GHGRP)](https://www.canada.ca/en/environment-climate-change/services/climate-change/greenhouse-gas-emissions/facility-reporting/about.html). Emissions data are self-reported as mandated in Section 46 of the *Canadian Environmental Protection Act, 1999*.

## Running

Run `docker compose --profile frontend up` in the root directory to launch api and database and expose them to localhost:8080.

## Api Health
http://localhost:8080/ping should return a status 200 and http://localhost:8080/actuator/health should return an api health check.

## Project Resources

[To add when completed]
- Project Documentation
- Design Documentation
- Development Documentation


## References

[To add when completed]
- Data Sources:
    - Government of Canada. (2024). *Greenhouse Gas Reporting Program (GHGRP) - Facility Greenhouse Gas (GHG) Data* (f28ef77a-cc0b-4353-90ac-c9d97f855bc8; 2022) [PDGES-GHGRP-GHGEmissionsSourcesGES-2022.csv]. Canada.ca. [Source](https://open.canada.ca/data/en/dataset/a8ba14b7-7f23-462a-bdbb-83b0ef629823)

- Tools & Libraries
