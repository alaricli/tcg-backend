import { Card } from "@/types/types";
import Image from "next/image";

async function fetchCards(): Promise<Card[]> {
  try {
    const response = await fetch("http://localhost:8080/api/card/get");

    if (!response.ok) {
      throw new Error("Failed to fetch cards");
    }

    return response.json();
  } catch (error) {
    console.error("Error fetching cards: ", error);
    return [];
  }
}

export default async function SetPage({
  params,
  searchParams,
}: {
  params: { setId: string };
  searchParams: { data: string };
}) {
  const { data } = await searchParams;
  const setData = JSON.parse(decodeURIComponent(data));

  const cards = await fetchCards();

  return (
    <div className="min-h-screen">
      <header className="bg-gradient-to-r from-indigo-500 to-pink-400 shadow-md p-6 flex items-center justify-between">
        {setData.setLogo && (
          <Image
            src={setData.setLogo}
            alt={`${setData.name} logo`}
            className="object-cover"
            height={100}
            width={100}
          />
        )}
        <div className="flex space-y-2 space-x-2">
          <h1 className="text-3xl font-semibold text-white">
            {setData.setName}
          </h1>
          <p className="text-gray-100">({setData.setCode})</p>
        </div>
        <div className="flex flex-col text-white">
          <p>Set Total: {setData.total}</p>
          <p>Release Date: {setData.setReleaseDate}</p>
        </div>
      </header>
      {/* Rest of your code for rendering Pokemon cards */}
      <div className="flex flex-wrap">
        {cards.map((card) => (
          <div key={card.id}>
            <div>
              <Image
                src={card.cardImages.small}
                alt={`${card.name} image`}
                className="object-cover"
                height={250}
                width={250}
              />
              <p>{card.name}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
