import { LoaderFunctionArgs } from "@remix-run/node";
import { useLoaderData } from "@remix-run/react";

export const loader = async ({ params }: LoaderFunctionArgs) => {
  const cardId = params.cardId;
  if (!cardId) {
    throw new Response("Not Found", { status: 404 });
  }
  // Add your data fetching logic here
  return { cardId };
};

export default function EditCard() {
  const { cardId } = useLoaderData<typeof loader>();
  return (
    <div>
      <h1>Edit Card {cardId}</h1>
      {/* Add your edit form here */}
    </div>
  );
}
