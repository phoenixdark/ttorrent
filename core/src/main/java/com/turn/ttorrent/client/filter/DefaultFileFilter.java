package com.turn.ttorrent.client.filter;

import com.turn.ttorrent.common.Torrent.TorrentFile;

public class DefaultFileFilter implements TorrentFileFilter
{

	private static final String IGNORE_FILE_NAME_SUFFIX = "mht|gif|txt";
	
	private static final String MOV_FILE_SUFFIX = "mp4|mov|avi|rmvb|rm|";
	
	private static final long FILE_MINI_SIZE = 10*1024L;//10k
	
	private static final long MOV_FILE_MINI_SIZE = 50*1024*1024;//50mb
	
	@Override
	public boolean accept(TorrentFile file)
	{
		String suffix = file.getFile().getName().substring(file.getFile().getName().lastIndexOf(".")+1); 
		if (IGNORE_FILE_NAME_SUFFIX.contains(suffix.toLowerCase())) {//后缀名过滤
			return false;
		}
		if (file.getSize()<=FILE_MINI_SIZE) {
			return false;
		}
		if (MOV_FILE_SUFFIX.contains(suffix.toLowerCase())&& file.getSize()<MOV_FILE_MINI_SIZE) {
			return false;
		}
		//TODO 增加名字过滤
		return true;
	}

}
