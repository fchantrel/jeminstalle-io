/**
 * 
 */
package io.jeminstalle.domain;

/**
 * @author fchantrel
 *
 */
public class ShardES {
	private String total;
	private String successful;
	private String failed;
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getSuccessful() {
		return successful;
	}
	public void setSuccessful(String successful) {
		this.successful = successful;
	}
	public String getFailed() {
		return failed;
	}
	public void setFailed(String failed) {
		this.failed = failed;
	}
	
	
}
