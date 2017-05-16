package com.vote.mapper;

import java.util.List;

import com.vote.entity.VoteItem;
import com.vote.entity.VoteOption;
import com.vote.entity.VoteSubject;

public interface VoteMapper {
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

	/**
	 * 查询投票主题
	 * @param subject
	 * @return
	 */
	public VoteSubject selectVote(VoteSubject subject);
	
	/**
	 * 查询所有的投票主题
	 * @param subject
	 * @return
	 */
	public List<VoteSubject> selectAllVote();
	
	/**
	 *  查询根据投票Id用户与投票表
	 * @param voteItem
	 * @return
	 */
	public VoteItem selectVoteitem(VoteItem voteItem);

	/**
	 * 查询有多少选项
	 * @param voteOption
	 * @return
	 */
	public VoteOption selectVoteOption(VoteOption voteOption);
}
