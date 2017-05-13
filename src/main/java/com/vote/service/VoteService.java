package com.vote.service;

import com.vote.entity.VoteItem;
import com.vote.entity.VoteOption;
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
	public int insertVoteOption(VoteOption option);

	/**
	 * 插入投票关系
	 * 
	 * @param item
	 * @return
	 */
	public int insertVoteitem(VoteItem item);
}
