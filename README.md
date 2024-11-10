# Student Organizer App

## Backend

...

## Frontend

### Running with Docker container

To access frontend using Docker, in the `frontend` directory, you can run:

```bash
docker build -t frontend .
docker run -p 3000:80 frontend
```

Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

### Running without Docker

To access frontend, in the `frontend` directory, you can run:

```bash
npm start
```

Runs the app in the development mode.
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.

You may also see any lint errors in the console.

```bash
npm test
```

Launches the test runner in the interactive watch mode.

```bash
npm run build
```

Builds the app for production to the `build` folder.

It correctly bundles React in production mode and optimizes the build for the best performance.

