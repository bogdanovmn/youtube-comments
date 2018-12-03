package com.github.bogdanovmn.youtubecomments.cli.dry;


import com.github.bogdanovmn.cmdlineapp.CmdLineAppBuilder;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;

import java.io.IOException;

public class App {
	static String apiKey = System.getProperty("youtube.apikey");
	static YouTube youtube = new YouTube.Builder(
		new NetHttpTransport(),
		new JacksonFactory(),
		request -> {}
	).setApplicationName("youtube-cmdline-sample")
		.build();

	public static void main(String[] args) throws Exception {
		new CmdLineAppBuilder(args)
			.withJarName("something")
			.withDescription("")
//			.withArg("term", "term to process")
			.withEntryPoint(
				cmdLine -> {
					videos();
				}
			).build().run();
	}

	static void search() throws IOException {
		// Define the API request for retrieving search results.
		YouTube.Search.List search = youtube.search().list("id,snippet");

		// Set your developer key from the {{ Google Cloud Console }} for
		// non-authenticated requests. See:
		// {{ https://cloud.google.com/console }}
		search.setKey(apiKey);
		search.setQ("test");

		// Restrict the search results to only include videos. See:
		// https://developers.google.com/youtube/v3/docs/search/list#type
//					search.setType("video");

		// To increase efficiency, only retrieve the fields that the
		// application uses.
		search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
		search.setMaxResults(2500L);
	}

	private static void videos() throws IOException {
		int pages = 0;
		SearchListResponse videos = youtube.search().list("id,snippet")
			.setKey(apiKey)
			.setType("video")
			.setChannelId("UCEnZxcVvM0mD6TDDwg_sbFg")
			.setMaxResults(50L)
			.setOrder("date")
			.setPublishedAfter(DateTime.parseRfc3339("2017-05-01T00:00:00Z"))
			.setPublishedBefore(DateTime.parseRfc3339("2017-05-07T00:00:00Z"))
			.execute();
		System.out.println(videos.getPageInfo());
		printVideos(videos);
//		pages++;
//
//		String nextPageToken = videos.getNextPageToken();
//		while (nextPageToken != null) {
//			videos = youtube.search().list("id")
//				.setKey(apiKey)
//				.setType("video")
//				.setMaxResults(50L)
//				.setChannelId("UCEnZxcVvM0mD6TDDwg_sbFg")
//				.setPublishedAfter(DateTime.parseRfc3339("2018-02-01T00:00:00Z"))
//				.setPublishedBefore(DateTime.parseRfc3339("2018-03-01T00:00:00Z"))
//				.setPageToken(nextPageToken)
//				.execute();
//			printVideos(videos);
//			pages++;
//			nextPageToken = videos.getNextPageToken();
//		}
//		System.out.println("Total pages: " + pages);
	}

	private static void printVideos(SearchListResponse videos) {
		System.out.println("----------> Videos: " + videos.getItems().size());
		videos.getItems().forEach(v -> System.out.println(v.getSnippet().getPublishedAt()));
	}
}
