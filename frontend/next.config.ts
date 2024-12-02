import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  images: {
    remotePatterns: [
      {
        protocol: "https",
        hostname: "archives.bulbagarden.net",
        port: "",
        pathname: "/media/upload/**",
      },
      {
        protocol: "https",
        hostname: "s3.amazonaws.com",
        port: "",
        pathname: "/pocket-game-assets.codex.gg/cards/**",
      },
    ],
  },
};

export default nextConfig;
