package com.vote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.entity.VoteItem;
import com.vote.entity.VoteOption;
import com.vote.entity.VoteSubject;
import com.vote.mapper.VoteMapper;
import com.vote.service.VoteService;

@Service("voteService")
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteMapper voteapper;

	@Override
	public int insertVote(VoteSubject subject) {
		return voteapper.insertVote(subject);
	}

	@Override
	public int insertVoteOption(VoteOption option) {
		return voteapper.insertVoteOption(option);
	}

	@Override
	public int insertVoteitem(VoteItem item) {
		return voteapper.insertVoteitem(item);
	}

	@Override
	public VoteSubject selectVote(VoteSubject subject) {
		return voteapper.selectVote(subject);
	}

	@Override
	public List<VoteSubject> selectAllVote() {
		return voteapper.selectAllVote();
	}

	@Override
	public VoteItem selectVoteitem(VoteItem voteItem) {
		return voteapper.selectVoteitem(voteItem);
	}

	@Override
	public int selectVoteOption(VoteOption voteOption) {
		return voteapper.selectVoteOption(voteOption);
	}

	@Override
	public List<VoteSubject> selectAllVoteId() {
		return voteapper.selectAllVoteId();
	}

}
