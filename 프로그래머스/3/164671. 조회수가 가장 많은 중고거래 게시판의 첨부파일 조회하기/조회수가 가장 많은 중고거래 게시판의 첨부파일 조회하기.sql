SELECT CONCAT('/home/grep/src/', B.BOARD_ID, '/', FILE_ID,FILE_NAME, FILE_EXT) AS FILE_PATH
FROM USED_GOODS_BOARD B
    JOIN USED_GOODS_FILE F
    ON B.BOARD_ID = F.BOARD_ID
WHERE B.BOARD_ID IN (
    SELECT BOARD_ID
    FROM USED_GOODS_BOARD
    WHERE VIEWS IN(
        SELECT MAX(VIEWS) FROM USED_GOODS_BOARD
    )    
)
ORDER BY FILE_ID DESC

