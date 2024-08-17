import Link from 'next/link';

const Navbar = () => {
  return (
    <nav>
      <ul>
        <li>
          <Link href="/">Home</Link>
        </li>
        <li>
          <Link href="/pages/cards">Decks</Link>
        </li>
        <li>
          <Link href="/pages/cards">Cards</Link>
        </li>
        <li>
          <Link href="/pages/cards">Tournaments</Link>
        </li>
        <li>
          <Link href="/pages/cards">Blog</Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
