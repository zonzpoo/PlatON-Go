package network

import (
	"crypto/rand"
	"math/big"

	"github.com/PlatONnetwork/PlatON-Go/consensus/cbft/protocols"
	types2 "github.com/PlatONnetwork/PlatON-Go/consensus/cbft/types"

	"github.com/PlatONnetwork/PlatON-Go/common"
	"github.com/PlatONnetwork/PlatON-Go/consensus/cbft/utils"
	"github.com/PlatONnetwork/PlatON-Go/core/types"
	"github.com/PlatONnetwork/PlatON-Go/p2p/discover"

	"github.com/PlatONnetwork/PlatON-Go/p2p"
)

// Create a new PrepareBlock for testing.
func newFakePrepareBlock() *protocols.PrepareBlock {
	block := types.NewBlockWithHeader(&types.Header{
		GasLimit: uint64(3141592),
		GasUsed:  uint64(21000),
		Coinbase: common.HexToAddress("8888f1f195afa192cfee860698584c030f4c9db1"),
		Root:     common.HexToHash("ef1552a40b7165c3cd773806b9e0c165b75356e0314bf0706f279c729f51e017"),
		Nonce:    types.EncodeNonce(utils.RandBytes(81)),
		Time:     big.NewInt(1426516743),
		Extra:    make([]byte, 100),
	})
	return &protocols.PrepareBlock{
		Epoch:        1,
		ViewNumber:   1,
		Block:        block,
		BlockIndex:   1,
		PrepareQC:    newQuorumCert(),
		ViewChangeQC: &types2.ViewChangeQC{},
		Signature:    newSignature(),
	}
}

// Create a new PrepareVote for testing.
func newFakePrepareVote() *protocols.PrepareVote {
	return &protocols.PrepareVote{
		Epoch:       1,
		ViewNumber:  1,
		BlockHash:   common.BytesToHash([]byte("I'm hash")),
		BlockNumber: 1,
		BlockIndex:  1,
		ParentQC:    newQuorumCert(),
		Signature:   newSignature(),
	}
}

func newQuorumCert() *types2.QuorumCert {
	return &types2.QuorumCert{
		Epoch:        1,
		ViewNumber:   1,
		BlockHash:    common.Hash{},
		BlockNumber:  1,
		BlockIndex:   1,
		Signature:    newSignature(),
		ValidatorSet: utils.NewBitArray(32),
	}
}

func newSignature() types2.Signature {
	return types2.Signature{}
}

// Create a new ViewChange for testing.
func newFakeViewChange() *protocols.ViewChange {
	return &protocols.ViewChange{
		Epoch:       1,
		ViewNumber:  1,
		BlockHash:   common.BytesToHash([]byte("I'm hash of viewChange")),
		BlockNumber: 1,
		PrepareQC:   newQuorumCert(),
		Signature:   newSignature(),
	}
}

// Create a new GetPrepareBlock for testing.
func newFakeGetPrepareBlock() *protocols.GetPrepareBlock {
	return &protocols.GetPrepareBlock{
		Epoch:      1,
		ViewNumber: 1,
		BlockIndex: 1,
	}
}

// Create a new GetBlockQuorumCert for testing.
func newFakeGetBlockQuorumCert() *protocols.GetBlockQuorumCert {
	return &protocols.GetBlockQuorumCert{
		BlockHash:   common.BytesToHash([]byte("GetBlockQuorumCert")),
		BlockNumber: 1,
	}
}

// Create a new BlockQuorumCert for testing.
func newFakeBlockQuorumCert() *protocols.BlockQuorumCert {
	return &protocols.BlockQuorumCert{
		BlockQC: newQuorumCert(),
	}
}

// Create a new GetQCBlockList for testing.
func newFakeGetQCBlockList() *protocols.GetQCBlockList {
	return &protocols.GetQCBlockList{
		BlockHash:   common.BytesToHash([]byte("GetQCBlockList")),
		BlockNumber: 1,
	}
}

// Create a new GetPrepareVote for testing.
func newFakeGetPrepareVote() *protocols.GetPrepareVote {
	return &protocols.GetPrepareVote{
		ViewNumber:  1,
		BlockHash:   common.BytesToHash([]byte("GetPrepareVote")),
		BlockNumber: 1,
		VoteBits:    utils.NewBitArray(32),
	}
}

// Create a new PrepareVotes for testing.
func newFakePrepareVotes() *protocols.PrepareVotes {
	return &protocols.PrepareVotes{
		BlockHash:   common.BytesToHash([]byte("PrepareVotes")),
		BlockNumber: 1,
		Votes:       []*protocols.PrepareVote{newFakePrepareVote()},
	}
}

// Create a new PrepareBlockHash for testing.
func newFakePrepareBlockHash() *protocols.PrepareBlockHash {
	return &protocols.PrepareBlockHash{
		BlockHash:   common.BytesToHash([]byte("PrepareBlockHash")),
		BlockNumber: 1,
	}
}

// Create a new QCBlockList for testing.
func newFakeQCBlockList() *protocols.QCBlockList {
	block := types.NewBlockWithHeader(&types.Header{
		GasLimit: uint64(3141592),
		GasUsed:  uint64(21000),
		Coinbase: common.HexToAddress("8888f1f195afa192cfee860698584c030f4c9db1"),
		Root:     common.HexToHash("ef1552a40b7165c3cd773806b9e0c165b75356e0314bf0706f279c729f51e017"),
		Nonce:    types.EncodeNonce(utils.RandBytes(81)),
		Time:     big.NewInt(1426516743),
		Extra:    make([]byte, 100),
	})
	return &protocols.QCBlockList{
		QC:     []*types2.QuorumCert{newQuorumCert()},
		Blocks: []*types.Block{block},
	}
}

// Create a new GetLatestStatus for testing.
func newFakeGetLatestStatus() *protocols.GetLatestStatus {
	return &protocols.GetLatestStatus{
		BlockNumber: 1,
		LogicType:   TypeForQCBn,
	}
}

// Create a new LatestStatus for testing.
func newFakeLatestStatus() *protocols.LatestStatus {
	return &protocols.LatestStatus{
		BlockNumber: 1,
		LogicType:   TypeForQCBn,
	}
}

// Create a new CbftStatusData for testing.
func newFakeCbftStatusData() *protocols.CbftStatusData {
	return &protocols.CbftStatusData{
		ProtocolVersion: 1,
		QCBn:            big.NewInt(1),
		QCBlock:         common.Hash{},
		LockBn:          big.NewInt(2),
		LockBlock:       common.Hash{},
		CmtBn:           big.NewInt(3),
		CmtBlock:        common.Hash{},
	}
}

// Create a new Ping for testing.
func newFakePing(pingTime string) *protocols.Ping {
	return &protocols.Ping{
		pingTime,
	}
}

// Create a new Pong for testing.
func newFakePong(pingTime string) *protocols.Pong {
	//pingTime := strconv.FormatInt(time.Now().UnixNano(), 10)
	return &protocols.Pong{
		pingTime,
	}
}

// fakePeer is a simulated peer to allow testing direct network calls.
type fakePeer struct {
	net   p2p.MsgReadWriter // Network layer reader/writer to simulate remote messaging.
	app   *p2p.MsgPipeRW    // Application layer reader/writer to simulate the local side.
	*peer                   // The peer belonging to CBFT layer.
}

// newFakePeer creates a new peer registered at the given protocol manager.
func newFakePeer(name string, version int, pm *EngineManager, shake bool) (*fakePeer, <-chan error) {
	// Create a message pipe to communicate through.
	app, net := p2p.MsgPipe()

	// Generate a random id and create the peer.
	var id discover.NodeID
	rand.Read(id[:])

	// Create a peer that belonging to cbft.
	peer := NewPeer(version, p2p.NewPeer(id, name, nil), net)

	// Start the peer on a new thread
	errc := make(chan error, 1)
	go func() {
		//
		errc <- pm.handler(peer.Peer, peer.rw)
	}()
	tp := &fakePeer{app: app, net: net, peer: peer}
	return tp, errc
}

// Create a new peer for testing, return peer and ID.
func newPeer(version int, name string) (*peer, discover.NodeID) {
	_, net := p2p.MsgPipe()

	// Generate a random id and create the peer.
	var id discover.NodeID
	rand.Read(id[:])

	// Create a peer that belonging to cbft.
	peer := NewPeer(version, p2p.NewPeer(id, name, nil), net)
	return peer, id
}

func newLinkedPeer(rw p2p.MsgReadWriter, version int, name string) (*peer, discover.NodeID) {
	// Generate a random id and create the peer.
	var id discover.NodeID
	rand.Read(id[:])

	// Create a peer that belonging to cbft.
	peer := NewPeer(version, p2p.NewPeer(id, name, nil), rw)
	return peer, id
}
