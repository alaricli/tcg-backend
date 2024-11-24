import { Link } from "@remix-run/react";
import { NavLink } from "~/types";

const navigationLinks: NavLink[] = [
  { href: "/", label: "Home" },
  { href: "/cards", label: "Cards" },
  { href: "/expansions", label: "Expansions" },
  { href: "/decks", label: "Decks" },
  { href: "/tournaments", label: "Tournaments" },
];

const Navbar = () => {
  return (
    <nav>
      <div className="flex items-center place-content-center p-2 bg-gray-900 text-white">
        {navigationLinks.map((link) => (
          <Link
            key={link.href}
            to={link.href}
            className="transition-colors duration-200 hover:text-gray-400 mx-2"
          >
            {link.label}
          </Link>
        ))}
      </div>
    </nav>
  );
};

export default Navbar;
