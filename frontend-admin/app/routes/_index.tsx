import type { MetaFunction } from "@remix-run/node";

export const meta: MetaFunction = () => {
  return [
    { title: "PRTCG Admin Dashboard" },
    {
      name: "admin dashboard for professorsresearchtcg.com",
      content: "PRTCG Admin Dashboard",
    },
  ];
};

export default function Index() {
  return (
    <div className="flex h-screen">
      <h1 className="text-2xl">
        professorsresearchtcg.com managements dashboard
      </h1>
    </div>
  );
}
