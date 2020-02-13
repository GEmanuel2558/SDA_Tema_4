CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_data`()
BEGIN

DECLARE counter INT DEFAULT 1;
declare incrementer int default 0;
declare random_month int default 1;
declare random_number_of_seets int default 1;
declare city_referince int default 1;
declare MIN_date date default '2020-01-01';
declare MAX_date date default '2021-12-31';
declare random_start_trip date default '2021-12-31';
declare random_end_trip date default '2021-12-31';
declare is_promoted bit default 0;
declare flight_id_departure int default 0;
declare flight_id_return int default 0;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table sda_tema_4.continent;
TRUNCATE table sda_tema_4.country;
TRUNCATE table sda_tema_4.city;
TRUNCATE table sda_tema_4.room;
TRUNCATE table sda_tema_4.hotel;
TRUNCATE table sda_tema_4.airport;
TRUNCATE table sda_tema_4.flight;
TRUNCATE table sda_tema_4.trip;
TRUNCATE table sda_tema_4.trip_details;
TRUNCATE table sda_tema_4.user;
TRUNCATE table sda_tema_4.roles;
TRUNCATE table sda_tema_4.user_roles;
truncate table tmp_log;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
commit;

insert into continent(`id`, `name`) values (1, 'Africa');
insert into continent(`id`, `name`) values (2, 'America de Nord');
insert into continent(`id`, `name`) values (3, 'America de Sud');
insert into continent(`id`, `name`) values (4, 'Antarctida');
insert into continent(`id`, `name`) values (5, 'Asia');
insert into continent(`id`, `name`) values (6, 'Australia');
insert into continent(`id`, `name`) values (7, 'Europa');
commit;

insert into country(`id`, `name`, `continent_id`) values (1, 'Bujumbura', 1);
insert into country(`id`, `name`, `continent_id`) values (2, 'Moroni', 1);
insert into country(`id`, `name`, `continent_id`) values (3, 'Moroni 2', 1);
insert into country(`id`, `name`, `continent_id`) values (4, 'Djibouti', 1);
insert into country(`id`, `name`, `continent_id`) values (5, 'The Valley', 2);
insert into country(`id`, `name`, `continent_id`) values (6, 'St. John\'s', 2);
insert into country(`id`, `name`, `continent_id`) values (7, 'Oranjestad', 2);
insert into country(`id`, `name`, `continent_id`) values (8, 'Nassau', 2);
insert into country(`id`, `name`, `continent_id`) values (9, 'Argentina', 3);
insert into country(`id`, `name`, `continent_id`) values (10, 'Bolivia', 3);
insert into country(`id`, `name`, `continent_id`) values (11, 'Brazilia', 3);
insert into country(`id`, `name`, `continent_id`) values (12, 'Istanbul', 5);
insert into country(`id`, `name`, `continent_id`) values (13, 'Dhaka', 5);
insert into country(`id`, `name`, `continent_id`) values (14, 'Mumbay', 5);
insert into country(`id`, `name`, `continent_id`) values (15, 'Delhi', 5);
insert into country(`id`, `name`, `continent_id`) values (16, 'Calcutta', 5);
insert into country(`id`, `name`, `continent_id`) values (17, 'Teheran', 5);
insert into country(`id`, `name`, `continent_id`) values (18, 'Belarus', 7);
insert into country(`id`, `name`, `continent_id`) values (19, 'Bulgaria', 7);
insert into country(`id`, `name`, `continent_id`) values (20, 'Republica Moldova', 7);
insert into country(`id`, `name`, `continent_id`) values (21, 'Polonia', 7);
insert into country(`id`, `name`, `continent_id`) values (22, 'Romania', 7);
commit;

insert into city(`id`, `name`, `country_id`) values (1, 'Bujumbura', 1);
insert into city(`id`, `name`, `country_id`) values (2, 'Moroni', 1);
insert into city(`id`, `name`, `country_id`) values (3, 'Moroni 2', 1);
insert into city(`id`, `name`, `country_id`) values (4, 'Djibouti', 1);
insert into city(`id`, `name`, `country_id`) values (5, 'The Valley', 2);
insert into city(`id`, `name`, `country_id`) values (6, 'St. John\'s', 2);
insert into city(`id`, `name`, `country_id`) values (7, 'Oranjestad', 2);
insert into city(`id`, `name`, `country_id`) values (8, 'Nassau', 2);
insert into city(`id`, `name`, `country_id`) values (9, 'Argentina', 3);
insert into city(`id`, `name`, `country_id`) values (10, 'Bolivia', 3);
insert into city(`id`, `name`, `country_id`) values (11, 'Brazilia', 3);
insert into city(`id`, `name`, `country_id`) values (12, 'Istanbul', 5);
insert into city(`id`, `name`, `country_id`) values (13, 'Dhaka', 5);
insert into city(`id`, `name`, `country_id`) values (14, 'Mumbay', 5);
insert into city(`id`, `name`, `country_id`) values (15, 'Delhi', 5);
insert into city(`id`, `name`, `country_id`) values (16, 'Calcutta', 5);
insert into city(`id`, `name`, `country_id`) values (17, 'Teheran', 5);
insert into city(`id`, `name`, `country_id`) values (18, 'Belarus', 7);
insert into city(`id`, `name`, `country_id`) values (19, 'Bulgaria', 7);
insert into city(`id`, `name`, `country_id`) values (20, 'Republica Moldova', 7);
insert into city(`id`, `name`, `country_id`) values (21, 'Polonia', 7);
insert into city(`id`, `name`, `country_id`) values (22, 'Romania', 7);
commit;



INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 1', 'hotel 1', '1', '1');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 2', 'hotel 2', '1', '1');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 3', 'hotel 3', '2', '1');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 4', 'hotel 4', '1', '1');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 5', 'hotel 5', '2', '2');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 6', 'hotel 6', '2', '2');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 7', 'hotel 7', '2', '3');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 8', 'hotel 8', '3', '4');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 9', 'hotel 9', '2', '5');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 10', 'hotel 10', '1', '6');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 11', 'hotel 11', '3', '7');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 12', 'hotel 12', '2', '8');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 13', 'hotel 13', '1', '8');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 14', 'hotel 14', '2', '8');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 15', 'hotel 15', '3', '9');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 16', 'hotel 16', '1', '10');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 17', 'hotel 17', '3', '10');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 18', 'hotel 18', '2', '10');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 19', 'holte 19', '1', '11');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 20', 'holte 20', '1', '11');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 21', 'hotel 21', '1', '12');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 22', 'hotel 22', '2', '13');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 23', 'holte 23', '3', '13');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descierea 24', 'hotel 24', '1', '14');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 25', 'hotel 25', '1', '15');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 26', 'hotel 26', '1', '16');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'decrierea 27', 'hotel 27', '2', '17');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 28', 'hotel 28', '3', '18');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 29', 'hotel 29', '1', '18');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 30', 'hotel 30', '2', '19');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 31', 'hotel 31', '3', '20');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'descrierea 32', 'hotel 32', '1', '21');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'description 33', 'hotel 33', '3', '22');
INSERT INTO `sda_tema_4`.`hotel` ( `description`, `name`, `standard`, `city_id`) VALUES ( 'description 34', 'hotel 34', '1', '22');
commit;

   WHILE counter <= 34  DO
		set random_month = FLOOR((RAND() * 12)+1);
		insert into tmp_log(id, msg) values (counter, concat('room counter = ', counter));
        set incrementer =1;
			while (incrementer <= 3) do
				if (0 = (FLOOR((RAND() * 100)+1) % 2)) then
					insert into room(from_date, available_double_rooms, available_single_room, extra_beds, double_room_price, single_room_price, extra_bed_price, to_date, hotel_id)
					values (
					STR_TO_DATE(concat('2020-', random_month, '-01'),"%Y-%m-%d"),
					1,
					0,
					FLOOR((RAND() * 2)+1),
					FLOOR((RAND() * 100)+1),
					0,
					FLOOR((RAND() * 100)+1),
					STR_TO_DATE(concat('2020-', random_month, '-20'),"%Y-%m-%d"),
					counter);
				else
					insert into room(from_date, available_double_rooms, available_single_room, extra_beds, double_room_price, single_room_price, extra_bed_price, to_date, hotel_id)
					values (
					STR_TO_DATE(concat('2020-', random_month, '-01'),"%Y-%m-%d"),
					0,
					1,
					FLOOR((RAND() * 2)+1),
					0,
					FLOOR((RAND() * 100)+1),
					FLOOR((RAND() * 100)+1),
					STR_TO_DATE(concat('2020-', random_month, '-20'),"%Y-%m-%d"),
					counter);
                    set incrementer = incrementer +1;
				end if;
            end while;
		SET counter = counter + 1;
	END WHILE;
	commit;

   set counter = 1;
   WHILE counter <= 500  DO
		set city_referince = counter % 22;
        if ( 0 = city_referince ) then
			set city_referince = city_referince + 1;
        end if;
		insert into tmp_log(id, msg) values (counter, concat('airport counter = ', city_referince));
		insert into airport (`name`, `city_id`) values (concat('airport ', counter), city_referince);
		SET counter = counter + 1;
	END WHILE;
	commit;

   set counter = 1;
   WHILE counter <= 500  DO
		set random_month = FLOOR((RAND() * 12)+1);
        set random_number_of_seets = FLOOR((RAND() * 40)+1);

		insert into tmp_log(id, msg) values (counter, concat('flight counter = ', counter));
		insert into flight (departure_date, flight_number, flight_price, retailabe_seats, number_of_seets, airport_id)
			values (
			TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, MIN_date, MAX_date)), MIN_date),
			LEFT(UUID(), 8),
			FLOOR((RAND() * 300)+1),
			random_number_of_seets,
			random_number_of_seets,
			counter
			);

		insert into flight (departure_date, flight_number, flight_price, retailabe_seats, number_of_seets, airport_id)
			values (
			TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, MIN_date, MAX_date)), MIN_date),
			LEFT(UUID(), 8),
			FLOOR((RAND() * 300)+1),
			random_number_of_seets,
			random_number_of_seets,
			FLOOR((RAND() * 499)+1)
			);

		if (0 = (counter % 2)) then
			insert into flight (departure_date, flight_number, flight_price, retailabe_seats, number_of_seets, airport_id)
				values (
				TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, MIN_date, MAX_date)), MIN_date),
				LEFT(UUID(), 8),
				FLOOR((RAND() * 300)+1),
				random_number_of_seets,
				random_number_of_seets,
				FLOOR((RAND() * 499)+1)
				);
        end if;
		SET counter = counter + 1;
	END WHILE;
	commit;

   set counter = 1;
   WHILE counter <= 500  DO
		set random_start_trip = TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, MIN_date, MAX_date)), MIN_date);
        set random_end_trip = DATE_ADD(random_start_trip, INTERVAL (FLOOR((RAND() * 14)+1)) DAY);
        if (0 = (FLOOR((RAND() * 5)+1) % 2)) then
			set is_promoted = 1;
        else
			set is_promoted = 0;
        end if;

		select id into flight_id_departure from flight f where f.departure_date>=random_start_trip order by f.departure_date asc limit 1;
        if ( flight_id_departure is not null ) then
			select id into flight_id_return from flight f where f.departure_date>=flight_id_departure order by f.departure_date asc limit 1;
			if ( flight_id_return is not null ) then

            	insert into tmp_log(id, msg) values (counter, concat('trip counter = ', counter));
				insert into trip(checkin_to_hotel, checkout_from_hotel, promoted, flight_id_departure, flight_id_return, hotel_id)
					values (
					random_start_trip,
					random_end_trip,
					is_promoted,
					flight_id_departure,
					flight_id_return,
					FLOOR((RAND() * 34)+1)
					);

            end if;
        end if;
		SET counter = counter + 1;
	END WHILE;
	commit;
END