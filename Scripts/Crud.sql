SELECT * FROM article_content;

insert into xdp_user_tmp(user_id,user_pw,user_nm) 
	SELECT org_cd,org_cd,org_nm 
	FROM M_ORG_BASE T1 
	WHERE NOT EXISTS (SELECT ORG_NM 
		FROM M_ORG_BASE_BACKUP_20111024 T2 
		WHERE T1.ORG_CD = T2.ORG_CD) 
		and T1.org_div_cd not in ('98','99'