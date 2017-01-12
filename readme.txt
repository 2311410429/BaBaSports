MyBatis仅注入Dao
Spring仅注入Service
SpringMVC仅注入Controller

约定：
网页：后台.do  前台.shtml
移动设备：安卓.apk 苹果.deb



少：
		   <dependency>
            <groupId>com.danga</groupId>
            <artifactId>memcached</artifactId>
            <version>2.0.1</version>
        </dependency>

        <dependency>
            <groupId>memcached-util</groupId>
            <artifactId>memcached</artifactId>
            <version>1.1</version>
        </dependency>
		<!--jcaptcha -->
		<dependency>
			<groupId>com.octo.captcha</groupId>
			<artifactId>jcaptcha-my</artifactId>
			<version>1.0</version>
		</dependency>
不一致：
        原：
        <dependency>
                    <groupId>oscache</groupId>
                    <artifactId>oscache</artifactId>
                    <version>2.4.1</version>
        </dependency>
        现用：
        <dependency>
            <groupId>opensymphony</groupId>
            <artifactId>oscache</artifactId>
            <version>2.4.1</version>
        </dependency>