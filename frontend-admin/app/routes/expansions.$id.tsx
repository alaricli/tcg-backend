import { LoaderFunction } from "@remix-run/node";
import { useLoaderData } from "@remix-run/react";
import CardsDisplayComponent from "~/components/common/CardsDisplayComponent";
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
    return data;
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
            <CardsDisplayComponent key={card.id} card={card} />
          ))}
        </ul>
      ) : (
        <p>No cards available for this expansion.</p>
      )}
    </div>
  );
}
