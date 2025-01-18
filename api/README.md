## Building
  Run `docker compose up --build` to build the project. There may be some cases
  where the repo and your docker get out of sync. If so, run `docker compose
  down`, and then delete the old out of sync volume by running `docker volume
  ls` to find the correct volume and then `docker volume rm the-correct-volume`
  to delete. Once you have done this you can then run `docker compose up
  --build` again to build the project.

## API Documentation
  The API documentation is available at `localhost:8080/swagger-ui/index.html`
  when the app is running. This will provide documentation about all of the
  current API endpoints. You can also test the endpoints to see that http
  reposes they return by clicking on the endpoint and clicking "try it out".

## Uploading GHG data
  When the application is first built, or if the volume is deleted, there will
  be no greenhouse data in the database, and you must upload the data. This is
  because the dataset itself is rather large (around 9mb), so it was not
  appropriate to commit it to the repo.

  Download the dataset from the web, and then use the `/api/v1/upload` endpoint to
  upload the new data.

  [Current dataset](https://data-donnees.az.ec.gc.ca/data/substances/monitor/greenhouse-gas-reporting-program-ghgrp-facility-greenhouse-gas-ghg-data/PDGES-GHGRP-GHGEmissionsGES-2004-Present.csv)



  
  
