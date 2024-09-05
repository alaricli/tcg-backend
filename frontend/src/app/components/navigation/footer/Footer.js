const Footer = () => {
  return (
    <footer className="bg-gray-900 p-4 text-center text-white">
      <div className="space-y-2">
        <p>Copyright © {new Date().getFullYear()} Professor's Research TCG</p>
        <p>
          Follow us on
          <a
            href="https://twitter.com"
            target="_blank"
            rel="noopener noreferrer"
            style={{ marginLeft: '5px' }}
          >
            Twitter
          </a>
        </p>
        <p className="text-left text-xs">
          The literal and graphical information presented on this website about
          the Pokémon Trading Card Game, including card images and text, is
          copyright The Pokémon Company (Pokémon), Nintendo, Game Freak and/or
          Creatures. This website is not produced by, endorsed by, supported by,
          or affiliated with Pokémon, Nintendo, Game Freak or Creatures.
        </p>
      </div>
    </footer>
  );
};

export default Footer;
