package com.ajahsma.caapp.dto;

public class NatureOfAssignmentDto 
{
		private int natureOfAssignmentId;
		
		private String natureOfAssignmentName;

		/**
		 * @return the natureOfAssignmentId
		 */
		public int getNatureOfAssignmentId() {
			return natureOfAssignmentId;
		}

		/**
		 * @param natureOfAssignmentId the natureOfAssignmentId to set
		 */
		public void setNatureOfAssignmentId(int natureOfAssignmentId) {
			this.natureOfAssignmentId = natureOfAssignmentId;
		}

		/**
		 * @return the natureOfAssignmentName
		 */
		public String getNatureOfAssignmentName() {
			return natureOfAssignmentName;
		}

		/**
		 * @param natureOfAssignmentName the natureOfAssignmentName to set
		 */
		public void setNatureOfAssignmentName(String natureOfAssignmentName) {
			this.natureOfAssignmentName = natureOfAssignmentName;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "NatureOfAssignmentDto [natureOfAssignmentId=" + natureOfAssignmentId + ", natureOfAssignmentName="
					+ natureOfAssignmentName + "]";
		}
		
		
		
	
}
