import Link from "next/link";

const Navbar = () => {
  return (
    <nav className="bg-gray-900 p-4">
      <div className="flex justify-center">
        <ul className="flex space-x-6 text-white font-medium text-xl">
          <li>
            <Link href="/">
              <p className="hover:text-orange-400">Home</p>
            </Link>
          </li>
          <li>
            <Link
              href={{
                pathname: `/sets/A1`,
                query: {
                  data: encodeURIComponent(
                    JSON.stringify({
                      setId: "A1",
                      setName: "Genetic Apex",
                      setCode: "A1",
                      setReleaseDate: "2024/10/30",
                      setTotal: 286,
                      setLogo:
                        "https://archives.bulbagarden.net/media/upload/7/77/A1_Set_Logo_EN.png",
                    })
                  ),
                },
              }}
            >
              <p className="hover:text-orange-400">Cards</p>
            </Link>
          </li>
          <li>
            <Link href="/sets">
              <p className="hover:text-orange-400">Sets</p>
            </Link>
          </li>
          {/* <li>
            <Link href="/decks">
              <p className="hover:text-orange-400">Decks</p>
            </Link>
          </li>
          <li>
            <Link href="/meta">
              <p className="hover:text-orange-400">Meta</p>
            </Link>
          </li>
          <li>
            <Link href="/articles">
              <p className="hover:text-orange-400">Articles</p>
            </Link>
          </li> */}
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;
