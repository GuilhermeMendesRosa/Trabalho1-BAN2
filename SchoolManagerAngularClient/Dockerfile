# Use the official Node.js image as a base image
FROM node:latest

# Set the working directory to /app
WORKDIR /app

# Copy the package.json and package-lock.json files to the container
COPY package*.json ./

# Install Angular CLI globally
RUN npm install -g @angular/cli

# Install dependencies
RUN npm install

# Copy the content of the local src directory to the container
COPY . .

# Expose port 4200 for the Angular app
EXPOSE 4200

# Start the Angular app
CMD ["npm", "start", "--", "--host", "0.0.0.0", "--disable-host-check"]
