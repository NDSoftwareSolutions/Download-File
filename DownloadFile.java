class DownloadMusicFile extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... musicURL) {
            int count;
            try {
                URL url = new URL(musicURL[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                InputStream input = new BufferedInputStream(url.openStream(), 8192);
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "filename.mp3");
                OutputStream output = new FileOutputStream(file);

                byte data[] = new byte[1024];

                while ((count = input.read(data)) != -1) {
                    output.write(data, 0, count);
                }

                output.flush();
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getContext(), "Music Download complete.", Toast.LENGTH_SHORT).show();
        }
    }
