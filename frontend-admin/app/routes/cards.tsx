import { LoaderFunction } from "@remix-run/node";
import CardsDisplay from "~/components/displays/CardsDisplay";
import AddCardsForm from "~/components/forms/AddCardsForm";

export const loader: LoaderFunction = async () => {
  try {
    const response = await fetch("http://localhost:8080/api/card/get");

    if (!response.ok) {
      throw new Error("Failed to fetch cards");
    }

    const data = await response.json();
    return data;
  } catch (err) {
    throw new Response("Failed to fetch cards", { status: 500 });
  }
};

const CardsManagementPage = () => {
  return (
    <div className="min-h-screen bg-gray-50">
      <h1 className="p-2 text-3xl items-center justify-center flex">
        Cards Management
      </h1>
      <div className="p-4 flex flex-col items-center">
        <div>
          <AddCardsForm />
        </div>
        <div className="w-full">
          <CardsDisplay />
        </div>
      </div>
    </div>
  );
};

export default CardsManagementPage;
