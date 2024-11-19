import { useLoaderData } from "@remix-run/react";

const DisplayAllExpansions = () => {
  const expansions =
    useLoaderData<{ id: number; series: string; name: string }[]>() || [];

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
                <button className="mr-2">
                  <p className="hover:underline">view</p>
                </button>
                <button className="mr-2">
                  <p className="hover:underline">edit</p>
                </button>
                <button className="">
                  <p className="text-red-700 hover:underline">delete</p>
                </button>
              </div>
            </li>
          ))}
        </ul>
      )}
      <p>click view to go to dedicated expansion page</p>
      <p>click edit to dropdown textbox to quickly edit series or name</p>
      <p>click delete to quickly delete</p>
    </div>
  );
};

export default DisplayAllExpansions;
