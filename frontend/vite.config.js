import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import dns from 'dns';

dns.setDefaultResultOrder('verbatim');

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    host: '0.0.0.0',  // Binding to localhost could work in some cases
    port: 5173,
  },
})
