import { json, LoaderFunction } from "@remix-run/node";
import { useLoaderData } from "@remix-run/react";
import DeleteButton from "~/components/common/DeleteButton";
import DeleteCardButton from "~/components/common/DeleteCardButton";
import { Expansion } from "~/types";

export const loader: LoaderFunction = async ({ params }) => {
  const { id } = params;

  try {
    const response = await fetch(
      `http://localhost:8080/api/expansion/get/${id}`
    );
    if (!response.ok) {
      throw new Error("Failed to fetch expansion");
    }

    const data = await response.json();
    return json(data);
  } catch (err) {
    throw new Response("Error loading expansion", { status: 500 });
  }
};

export default function ExpansionDetails() {
  const expansion = useLoaderData<Expansion>();

  return (
    <div className="p-6 bg-white shadow-lg rounded-lg max-w-2xl mx-auto mt-10">
      <p>
        <strong>ID:</strong> {expansion.id}
      </p>
      <p>
        <strong>Series:</strong> {expansion.series}
      </p>
      <p>
        <strong>Name:</strong> {expansion.name}
      </p>
      <p>
        <strong>Cards:</strong>
      </p>
      {expansion.cards && expansion.cards.length > 0 ? (
        <ul className="space-y-4">
          {expansion.cards.map((card) => (
            <li key={card.id} className="p-4 border rounded-lg shadow">
              <img
                // src={card.picUrl || "http://example.com/pikachu.png"}
                src="https://assets.pokemon.com/static-assets/content-assets/cms2/img/cards/web/SV08/SV08_EN_59.png"
                alt={card.name || "Card image"}
                className="w-full h-auto max-w-xs rounded mb-4"
              />
              <p>
                <strong>ID:</strong> {card.id}
              </p>
              <p>
                <strong>Name:</strong> {card.name || "Unknown"}
              </p>
              <p>
                <strong>Artist:</strong> {card.artist}
              </p>
              <p>
                <strong>HP:</strong> {card.hp || "N/A"}
              </p>
              <p>
                <strong>Rarity:</strong> {card.rarity}
              </p>
              <p>
                <strong>Price:</strong> ${card.price?.toFixed(2) || "N/A"}
              </p>
              <p>
                <strong>Type:</strong>{" "}
                {card.pokemonCardType ||
                  card.trainerCardType ||
                  card.energyCardType ||
                  "N/A"}
              </p>
              <p>
                <strong>Energy Type:</strong> {card.energyType || "N/A"}
              </p>
              <DeleteCardButton cardId={card.id} />
            </li>
          ))}
        </ul>
      ) : (
        <p>No cards available for this expansion.</p>
      )}
    </div>
  );
}
