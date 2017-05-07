package com.vote.service;

import com.vote.entity.VoteItem;
import com.vote.entity.VoteSubject;

public interface VoteService {
	/**
	 * 投票主题
	 * 
	 * @param subject
	 * @return
	 */
	public int insertVote(VoteSubject subject);

	/**
	 * 投票选项
	 * 
	 * @param item
	 * @return
	 */
	public int insertVoteItem(VoteItem item);

}
