/**
 * 
 */
package io.jeminstalle.domain;

/**
 * @author fchantrel
 *
 */
public class DenombrementES {
	private int count;
	
	private ShardES _shards;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ShardES get_shard() {
		return _shards;
	}

	public void set_shard(ShardES _shard) {
		this._shards = _shard;
	}
}
