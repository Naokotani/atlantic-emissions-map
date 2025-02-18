# Atlantic Emissions Map

V1

Date: January–April 2025\
Authors: Chris Hughes, Nick Richardson, Rose Scoville


## About

The Atlantic Emissions Map (AEM) displays the latest reported greenhouse gas (GHG) emissions from large industrial facilities across the Atlantic provinces. This project's goal is to make the data, and the story they tell, easily accessible to industry and non-industry Atlantic Canadians alike.

The data shown are current as of October 31, 2023, and will be updated as the latest data is released from the Government of Canada's [Greenhouse Gas Reporting Program (GHGRP)](https://www.canada.ca/en/environment-climate-change/services/climate-change/greenhouse-gas-emissions/facility-reporting/about.html). Emissions data are self-reported as mandated in Section 46 of the *Canadian Environmental Protection Act, 1999*.

## Running

Run `docker compose up` in the root directory. This will launch the Frontend React app, build and start the Java Api, launch 
the Nginx server and start the database.

## Usage
There are two versions of the frontend http://localhost:5173 is the development version. This is being served by Vite with
hot module reload, so you will see the changes that you make to the frontend as you change the files. The other is at
http://localhost:8081. This is a production version where the static files have been built and are being served by Nginx
instead of Vite.

Additionally, you will find the swagger API reference at http://localhost:8080/swagger-ui/index.html.
This will show the API endpoints provided by the backend. You can also access the rest of the api directly
through port 8080.

Finally, you can access the database directly through http://localhost:5432 (IE, to have access to the database in your IDE).


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
