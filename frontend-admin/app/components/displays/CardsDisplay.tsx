import { useLoaderData } from "@remix-run/react";
import { useState } from "react";
import { Card } from "~/types";
import CardsDisplayComponent from "../common/CardsDisplayComponent";

const CardsDisplay = () => {
  const initialCards = useLoaderData<Card[]>() || [];
  const [cards, setCards] = useState(initialCards);

  return (
    <div>
      <h2>All Cards</h2>
      {cards.length === 0 ? (
        <p className="text-red-700">No cards available.</p>
      ) : (
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3">
          {cards?.map((card) => (
            <CardsDisplayComponent key={card.id} card={card} />
          ))}
        </div>
      )}
    </div>
  );
};

export default CardsDisplay;
