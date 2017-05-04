package com.turn.ttorrent.client.filter;

import com.turn.ttorrent.common.Torrent.TorrentFile;

public interface TorrentFileFilter
{
	boolean accept(TorrentFile pathname);
}
