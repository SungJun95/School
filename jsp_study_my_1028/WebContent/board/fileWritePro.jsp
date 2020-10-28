<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.exam.dao.BoardDao"%>
<%@page import="com.exam.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--   ↑ 위코드에 의해 response의 데이터는 UTF-8로 처리    -->
 <%
 // 파일 업로드 위해서 cos.jar 라이브러리를 프로젝트 빌드패스에 추가
 
 // 실제물리적 경로 구하기
String realPath = application.getRealPath("/upload");
System.out.println("realPath : " + realPath);
 
 //파일 업로드하기
MultipartRequest multi = new MultipartRequest(  // 멀티파트리퀘스트는 jsp액션태그랑 연동이안되기때문에 자바기본문법을 사용해야한다.
		request,
		realPath,
		1024 * 1024 * 20,		// 최대 20MB바이트 (디폴트값은 KB)
		"utf-8",
		new DefaultFileRenamePolicy()); 
// enctype="mulipart/form-data" 로 전송받으면 기본내장객체인 request에서 파라미터값을 바로 찾을수 없음
// MultipartRequest 객체로부터 파라미터값을 찾아야함. 사용방법은 동일
 
// 업로드 객체 생성할때 필요한 인자값
// 1. request (사용자 요청정보)
// 2. 업로드 할 폴더의 물리적 경로
// 3. 업로드 파일의 최대 크기 제한
// 4. 파일명 한글처리 utf-8
// 5. 파일명 중복될때 이름변경규칙 가진 객체를 전달
 

 
// post 파라미터값 한글처리
// request.setCharacterEncoding("utf-8");  // 요청(request)에 의해 넘어오는 데이터를 utf-8 로 처리.
// ↑ post 파라미터값 한글처리는 이미 MultipartRequest생성자에서 처리하기때문에 할필요없음


// pageNum 파라미터값 가져오기
	String pageNum = multi.getParameter("pageNum"); 
// MultipartRequest 기능을 쓰려면 jsp form의 enctype을 multipart/form-data으로 설정해 줘야 하는데 이럴 경우 request.getParameter로 파라미터 값을 가져올 경우 null값이 들어온다
// 이럴때는 MultiparRequest에서 제공하는 getParameter로 파라미터써야 값을 가져올수 있다.

// 제이쿼리문으로 받은 pageNum이 null 이면 단순"null"문자 그대로 출력되고 키값이 없는 경우는 "" 빈문자열이 나타난다. ex) pageNum=null,  pageNum=
// pageNum의 null 값이 단순문자데이터 이기때문에 오류가나더라도 nullPointerException이 아니고 NumberFormatException.forInputString 이 일어난다. (*list.jsp에서)

// VO 객체 준비
BoardVo boardVo = new BoardVo();

// 파라미터값 가져와서 VO에 저장. MultipartRequest 로부터 찾는다.
boardVo.setName(multi.getParameter("name"));
boardVo.setPasswd(multi.getParameter("passwd"));
boardVo.setSubject(multi.getParameter("subject"));
boardVo.setContent(multi.getParameter("content"));
// 업로드한 원본 파일이름 가져오기 
System.out.println("원본파일명 : " + multi.getOriginalFileName("filename"));
//업로드한 실제 파일이름 가져오기 
System.out.println("실제파일명 : " + multi.getFilesystemName("filename"));
boardVo.setFile(multi.getFilesystemName("filename"));

// DAO 객체 준비
BoardDao boardDao = BoardDao.getInstance();

// 글번호 가져와서 VO에 저장
int nextNum = boardDao.getNextNum();
boardVo.setNum(nextNum);

// ip  regDate  readcount  값 저장
boardVo.setIp(request.getRemoteAddr()); // IP주소 가져오기
boardVo.setRegDate(new Timestamp(System.currentTimeMillis()));
boardVo.setReadcount(0);  // 조회수

// re_ref  re_lev  re_seq
boardVo.setReRef(nextNum); // 주글일때는 글번호가 그룹번호가 됨
boardVo.setReLev(0); // 주글일때는 들여쓰기 레벨이 0 (들여쓰기 없음)
boardVo.setReSeq(0); // 주글일때는 글그룹 내에서 순번이 0 (첫번째)

// 주글 등록하기
boardDao.addBoard(boardVo);

// 글내용 상세보기 화면 content.jsp로 이동
response.sendRedirect("content.jsp?num=" + boardVo.getNum() + "&pageNum=" + pageNum);
%>




