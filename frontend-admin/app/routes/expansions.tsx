import { ActionFunction, json, LoaderFunction } from "@remix-run/node";
import { Outlet, useMatches } from "@remix-run/react";
import DisplayAllExpansions from "~/components/displays/ExpansionsDisplay";
import AddExpansionsForm from "~/components/forms/AddExpansionsForm";
import { ActionData, Expansion } from "~/types";

export const action: ActionFunction = async ({ request }) => {
  const formData = await request.formData();
  const series = formData.get("series");
  const name = formData.get("name");

  try {
    const response = await fetch("http://localhost:8080/api/expansion/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ series, name }),
    });

    if (!response.ok) {
      throw new Error("Failed to add expansion");
    }

    const data = await response.json();
    return json<ActionData>({ success: true, data });
  } catch (err) {
    return json<ActionData>({ success: false, err: "Failed to add expansion" });
  }
};

export const loader: LoaderFunction = async () => {
  try {
    const response = await fetch("http://localhost:8080/api/expansion/get");

    if (!response.ok) {
      throw new Error("Failed to fetch expansions");
    }

    const data = await response.json();
    return json<Expansion[]>(data);
  } catch (err) {
    throw new Response("Failed to fetch expansions", { status: 500 });
  }
};

const ExpansionsManagementPage = () => {
  const matches = useMatches();
  const isChildRoute = matches.some(
    (match) =>
      match.pathname.includes("/expansions/") &&
      match.pathname !== "/expansions"
  );

  return (
    <div className="min-h-screen bg-gray-100 p-4">
      <h1 className="text-3xl font-semibold p-4">Expansions Management</h1>
      {!isChildRoute && (
        <>
          <div className="flex flex-col md:flex-row gap-4 justify-center items-start">
            <div className="w-full md:w-1/2 max-w-lg">
              <AddExpansionsForm />
            </div>
            <div className="w-full md:w-1/2 max-w-lg">
              <DisplayAllExpansions />
            </div>
          </div>
        </>
      )}
      <Outlet />
    </div>
  );
};

export default ExpansionsManagementPage;
