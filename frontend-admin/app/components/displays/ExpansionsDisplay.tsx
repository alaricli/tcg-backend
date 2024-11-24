import { Link, useLoaderData } from "@remix-run/react";
import { useState } from "react";
import DeleteButton from "../common/DeleteExpansionButton";
import { Expansion } from "~/types";

const DisplayAllExpansions = () => {
  const initialExpansions = useLoaderData<Expansion[]>() || [];

  const [expansions, setExpansions] = useState(initialExpansions);

  const handleDeleteSuccess = (id: number) => {
    setExpansions((prev) => prev.filter((expansion) => expansion.id !== id));
  };

  return (
    <div className="bg-white shadow-lg rounded-lg p-6 w-full max-w-lg mt-4">
      <h2 className="text-xl font-medium mb-4">All Expansions</h2>
      {expansions.length === 0 ? (
        <p className="text-red-700">No expansions available.</p>
      ) : (
        <ul>
          {expansions?.map((expansion) => (
            <li
              key={expansion.id}
              className="border border-gray-300 rounded-md p-3"
            >
              <p>
                <strong>ID:</strong> {expansion.id}
              </p>
              <p>
                <strong>series:</strong> {expansion.series}
              </p>
              <p>
                <strong>name:</strong> {expansion.name}
              </p>
              <div>
                <Link to={`/expansions/${expansion.id}`} className="mr-2">
                  <p className="hover:underline">view</p>
                </Link>
                <button className="mr-2">
                  <p className="hover:underline">edit</p>
                </button>
                <DeleteButton
                  expansionId={expansion.id}
                  onSuccess={() => handleDeleteSuccess(expansion.id)}
                />
              </div>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default DisplayAllExpansions;
