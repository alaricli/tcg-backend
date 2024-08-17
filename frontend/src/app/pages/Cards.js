const { default: Head } = require('next/head');
const { default: Link } = require('next/link');

// pages/newpage.jsimportHeadfrom"next/head";
const NewPage = () => {
  return (
    <>
      <Head>
        <title>New Page</title>
        <meta name="description" content="Description of New Page" />
      </Head>
      <div className="container mx-auto px-4">
        <h1 className="text-2xl font-bold my-6">Welcome to New Page</h1>
        <p>This is a new page in your Next.js application.</p>
        <Link href="/">
          <a className="text-blue-600 hover:underline">Go back home</a>
        </Link>
      </div>
    </>
  );
};

export default NewPage;
