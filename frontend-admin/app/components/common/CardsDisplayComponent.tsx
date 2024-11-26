import { Card } from "~/types";
import DeleteCardButton from "./DeleteCardButton";
import { Link, useNavigate } from "@remix-run/react";

type CardDisplayProps = {
  card: Card;
};

const CardsDisplayComponent = ({ card }: CardDisplayProps) => {
  return (
    <li key={card.id} className="p-4 border rounded-lg shadow">
      <h2 className="text-xl font-bold mb-2 text-center">
        {card.name || "Unknown"}
      </h2>
      <div className="flex items-start space-x-4">
        {/* leftside */}
        <div className="flex-shrink-0">
          <img
            // src={card.picUrl || "http://example.com/pikachu.png"}
            src={
              card.picUrl ||
              "https://assets.pokemon.com/static-assets/content-assets/cms2/img/cards/web/SV08/SV08_EN_192.png"
            }
            alt={card.name || "Card image"}
            className="w-full h-auto max-w-xs rounded mb-4"
          />
        </div>
        <div className="flex-grow">
          <p>
            <strong>ID:</strong> {card.id}
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
            {card.pokemonCardTypes && card.pokemonCardTypes.length > 0
              ? card.pokemonCardTypes.join(", ")
              : card.trainerCardTypes && card.trainerCardTypes.length > 0
              ? card.trainerCardTypes.join(", ")
              : card.energyCardTypes && card.energyCardTypes.length > 0
              ? card.energyCardTypes.join(", ")
              : "N/A"}
          </p>
          <p>
            <strong>Energy Type:</strong> {card.energyType || "N/A"}
          </p>
          <p>
            <strong>Format:</strong> {card.format || "N/A"}
          </p>
          <p>
            <strong>Expansion:</strong> {card.expansionName || "N/A"} #
            {card.cardNumber}
          </p>
        </div>
      </div>
      <div className="flex">
        <Link to={`/${card.id}/edit`} className="mr-2 hover:underline">
          edit
        </Link>
        <DeleteCardButton cardId={card.id} />
      </div>
    </li>
  );
};

export default CardsDisplayComponent;
