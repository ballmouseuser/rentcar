package com.pgy.rentcar.common;


public class PageManager {

	private int perBlock;// 화면하단 페이지 블럭에 몇 개를 표시할것인가?
	private int perPage;// 페이당 자료를 몇개씩 보일것인가?
	private int blockCount;// 총 몇개의 블럭으로 나누어 지는감/
	private int startPage; // 어떤 블럭의 시작 페이지
	private int endPage; // 어떤 블럭의 종료 페이지
	private int currentBlock; // 현재 페이지가 속한 블럭
	private int rowCount; // 총 자료수
	// 다른 곳에서 활용하기에 public(어떤 페이지의 시작글번호,끝글번호,거꾸로 넘버링할 표기번호(게시글번호와는 다름),총페이지수)
	public int startRow, endRow, number, pageCount, currentPage;

	// 처음 페이지관리자를 객체를 생성할 때에 2개의 기본정보를 결정해야 한다.
	// 페이지당 글 수(perPage), 페이지블럭당 페이지 수(perBlock)
	public PageManager(int perPage, int perBlock) {
		this.perPage = perPage;
		this.perBlock = perBlock;
	}

	// 자주 바뀌는 페이지관리자환경 정보 (총 게시글 수, 현재 페이지, 현재 블럭)
	public void setRowCount(int rowCount, int currentPage, int currentBlock) {
		this.currentPage = currentPage;
		this.rowCount = rowCount;
		this.currentBlock = currentBlock;
		number = rowCount - (currentPage - 1) * perPage;
		pageCount = getPageCount(rowCount);
		blockCount = getBlockCount(getPageCount(rowCount));// 총 몇개의 페이지 블럭으로
															// 나뉘었는가?
		startPage = getStartBlockPage(currentBlock, blockCount);// 이 블럭의 좌측 시작
		endPage = getEndBlockPage(currentBlock, blockCount, pageCount);
		if (endPage > pageCount)
			endPage = pageCount;
		startRow = getStartRow(currentPage, rowCount);
		endRow = getEndRow(currentPage, rowCount);

	}

	private int getPageCount(int rowCount) {
		return rowCount / perPage + (rowCount % perPage == 0 ? 0 : 1);
		// int temp = rowCount % perPage;
		// if (temp == 0) {
		// return rowCount / perPage;
		// } else {
		// return rowCount / perPage + 1;
		// }
	}

	private int getBlockCount(int pageCount) {
		int temp = pageCount % perBlock;
		if (temp == 0) {
			return pageCount / perBlock;
		} else {
			return pageCount / perBlock + 1;
		}
	}

	private int getStartBlockPage(int blockNum, int blockCount) {
		return (blockNum - 1) * perBlock + 1;
	}

	private int getEndBlockPage(int blockNum, int blockCount, int pageCount) {
		int res = blockNum * perBlock;
		return res;
	}

	private int getStartRow(int pageNum, int rowCount) {
		return (pageNum - 1) * perPage + 1;
	}

	private int getEndRow(int pageNum, int rowCount) {
		int res = (pageNum * perPage);
		if (res > rowCount)
			res = rowCount;
		return res;
	}

	/**
	 * 예를 호출해 리턴되는 스트림을 out.write()하면 된다.
	 * 
	 * @return
	 */
	public String getPagenation(String boardJSPFile) {
		StringBuffer buffer = new StringBuffer();
		String option = "";
		if (category != null) {
			option = "&category=" + category;
		}
		if (rowCount > 0) {
			buffer.append("<ul class='pagination'>");
			// [이전] 이라는 링크를 만들건지 파악
			if(startPage < perBlock) {
				buffer.append("<li class='disabled'><a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
			}else {
				int nextPage = currentPage - 1;
				// if(nextPage<1) nextPage=1;
				int nextBlock = currentBlock - 1;
				// if(nextBlock<1) nextBlock = 1;
//				buffer.append("<a href='" + boardJSPFile + "?pageNum=" + nextPage + "&blockNum=" + nextBlock + option + "' ");
//				buffer.append(" style='text-decoration: none; font-size: 80%;'>[이전]</a>");
				buffer.append("<li class='enable'>");
				buffer.append("<a href='" + boardJSPFile + "?pageNum=" + nextPage + "&blockNum=" + nextBlock + option + "' aria-label='Previous'");
				buffer.append("<span aria-hidden='true'>&laquo;</span></a></li>");

			}
			// 페이징처리
			for (int i = startPage; i <= endPage; i++) {
				buffer.append("<li><a href='" + boardJSPFile + "?pageNum=" + i + "&blockNum=" + currentBlock + option + "' ");
				buffer.append(" style='text-decoration: none; font-size: 100%;'>" + i + "</a></li> ");
			}
			
			
			// 다음이라는 링크를 만들건지 파악
			if (endPage < pageCount) {
				int nextPage = startPage + perBlock;
				int nextBlock = currentBlock + 1;
//				
//				buffer.append(" style='text-decoration: none; font-size: 80%;'>[다음]</a>");
				buffer.append("<li class='enable'>");
				buffer.append("<a href='" + boardJSPFile + "?pageNum=" + nextPage + "&blockNum=" + nextBlock + option + "' aria-label='Next'");
				buffer.append("<span aria-hidden='true'>&raquo;</span></a></li>");
				
			} else {
				buffer.append("<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
			}
			buffer.append("</ul>");
		}
		return buffer.toString();
	}

	// 카테고리와 같은 조건이 있는 경우 활용함 .
	// 페이지네이션 표기 부분을 다음과 같은 스타일로 정의
	/*
	 * <% pm.setCategory("" + category);
	 * out.write(pm.getPagenation("Main.jsp?center=CarCategoryList.jsp")); %>
	 */
	String category = null;

	public void setCategory(String category) {
		this.category = category;
	}

}